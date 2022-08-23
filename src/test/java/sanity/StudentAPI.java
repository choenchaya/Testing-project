package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extensions.Verifications;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIFlows;



@Listeners(utilities.LISTENERS.class)
public class StudentAPI extends CommonOps {

    @Test(description = "Get Student From Student List")
    @Description("This Verify Student From List")
    public void test01_VerifyStudent(){
       Verifications.verifyText(APIFlows.getStudentProperty("[0].firstName"),"Vernon");
    }

    @Test(description = "Add Student From Student List")
    @Description("This Verify Add Student To The List")
    public void test02_VerifyPostStudent(){
        APIFlows.PostStudent("Moshe","Choen","MOSHCHOEN02@gmail.com","Financial Analysis");
        Verifications.verifyText(APIFlows.getStudentProperty("[100].firstName"),"Moshe");
    }
    @Test(description = "Update Student In Student List")
    @Description("This Verify Update Student In The List")
    public void test03_VerifyPutStudent(){
        String id = APIFlows.getStudentProperty("[100].id");
        APIFlows.UpdateStudent("Moshe","Choen","MOSHCHOEN04@gmail.com","Financial Analysis",id);
        Verifications.verifyText(APIFlows.getStudentProperty("[100].email"),"MOSHCHOEN04@gmail.com");
    }
   @Test(description = "Delete Student In Student List")
    @Description("This Verify Delete Student From The List")
    public void test04_VerifyPutStudent(){
       String id = APIFlows.getStudentProperty("[100].id");
       APIFlows.DeleteStudent(id);
       Verifications.verifyListLength(APIFlows.listOfAPI(),100);


   }

}
