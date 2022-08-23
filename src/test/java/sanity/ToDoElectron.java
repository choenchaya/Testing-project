package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extensions.Verifications;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;


@Listeners(utilities.LISTENERS.class)
public class ToDoElectron extends CommonOps {

    @Test(description = "test01_DeleteTasks")
    @Description("This Test verify DeleteTasks")
    public void test01_DeleteTasks(){
        ElectronFlows.AddNewTask("Finish the project");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTask(),1);


    }
    @Test(description = "test02_verifyCompleteTasks")
    @Description("This Test verify Complete Tasks")
    public void test02_verifyCompleteTasks(){
        ElectronFlows.AddNewTask("Find a job");
        ElectronFlows.AddNewTask("Check the salary");
        ElectronFlows.CompleteAllTasks();
        Verifications.verifyNumber(ElectronFlows.getNumberOfTask(),0);

    }

}
