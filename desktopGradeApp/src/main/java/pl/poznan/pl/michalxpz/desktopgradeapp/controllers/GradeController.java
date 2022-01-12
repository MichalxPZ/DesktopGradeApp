package pl.poznan.pl.michalxpz.desktopgradeapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import pl.poznan.pl.michalxpz.desktopgradeapp.Person;
import pl.poznan.pl.michalxpz.desktopgradeapp.exceptions.InvalidNameAndSurnameException;
import pl.poznan.pl.michalxpz.desktopgradeapp.validators.GradeValidator;
import pl.poznan.pl.michalxpz.desktopgradeapp.validators.NameValidator;

import java.util.concurrent.atomic.AtomicReference;

public class GradeController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField gradeTextField;

    @FXML
    private TextField avgTextField;

    @FXML
    private Button addStudentButton;

    @FXML
    private Button sortButton;

    @FXML
    private TableView<Person> gradeList;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person,Integer> gradeCol;

    @FXML
    public TableColumn<Person, Void> delCol = new TableColumn<>();

    @FXML
    public Label errorLabel;

    public GradeController() {
    }

    @FXML
    private void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
        setupDeleteButton();
        avgTextField.setText("0.0");
    }

    public void addStudent() {
        String name = null;
        String grade = gradeTextField.getText();
        Integer gradeInt = null;
        try {
            name = NameValidator.parseName(nameTextField.getText());
            errorLabel.setText("");
            gradeInt = GradeValidator.parseGrade(grade);
            errorLabel.setText("");
            gradeList.getItems().add(new Person(name, gradeInt));
            updateAverage();
            nameTextField.setText("");
            gradeTextField.setText("");
            focusOnName();
        } catch (Exception e) {
            updateLabelText(e.toString());
        }
    }

    private void updateLabelText(String error) {
        errorLabel.setText(error);
    }

    public void updateAverage() {
        AtomicReference<Integer> sum = new AtomicReference<>(0);
        int studentsNum = gradeList.getItems().size();
        gradeList.getItems().forEach( it -> sum.updateAndGet(v -> v + it.getGrade()));

        double avg = sum.get();
        avg /= studentsNum;
        System.out.println(studentsNum);
        System.out.println(gradeList.getItems());
        avgTextField.setText(String.valueOf(avg));
    }

    public void sortTable() {
        gradeCol.setSortType(TableColumn.SortType.DESCENDING);
        gradeList.getSortOrder().add(gradeCol);
        gradeList.sort();
    }

    public void focusOnGrade() {
        gradeTextField.requestFocus();
    }

    public void focusOnName() {
        nameTextField.requestFocus();
    }

    public void deleteRow(Person data) {
        gradeList.getItems().remove(data);
    }

    public void setupDeleteButton() {
        Callback<TableColumn<Person, Void>, TableCell<Person, Void>> cellFactory = new Callback<>() {

            @Override
            public TableCell<Person, Void> call(TableColumn<Person, Void> param) {
                return new TableCell<>() {

                    private final Button btn = new Button("Remove");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Person data = getTableView().getItems().get(getIndex());
                            deleteRow(data);
                            updateAverage();
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
            }
        };
        delCol.setCellFactory(cellFactory);
        gradeList.getColumns().add(delCol);
    }
}

