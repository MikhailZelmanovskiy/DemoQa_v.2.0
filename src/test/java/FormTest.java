import models.StudentForm;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        app.form().selectItemForms();
        app.form().selectPracticeForm();
        app.form().hideFooter();

    }
    @Test
    public void formTest() {
        StudentForm studentForm = new StudentForm()
                .withFirstName("John")
                .withLastName("Dow")
                .withEmail("john@mail.com")
                .withGender("Male")
                .withPhone("1234567890")
                .withBirthday("28 May 1988")
                .withSubject("Maths")
                .withHobbies("Sport")
                .withAddress("Tel Aviv")
                .withState("NCR")
                .withCity("Gurgaon");

        app.form().fillForm(studentForm);
        app.form().saveNewStudent();
        Assert.assertTrue(app.form().isDialogDispleyed());
        app.form().closeDialog();
    }



}