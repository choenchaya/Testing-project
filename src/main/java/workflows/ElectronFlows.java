package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;

public class ElectronFlows extends CommonOps {

    @Step("Add New Task To The List")
    public static void AddNewTask(String taskName){
        wait.until(ExpectedConditions.visibilityOf(ToDoMainPage.CreateATask));
        UIActions.updateText(ToDoMainPage.CreateATask,taskName);
        UIActions.insetKey(ToDoMainPage.CreateATask, Keys.RETURN);
    }
    @Step("Add New Task To The List")
    public static void CompleteAllTasks(){
        UIActions.click(ToDoMainPage.ToggleAllCompleted);
        UIActions.click(ToDoMainPage.RightMenuBelow);
        UIActions.click(ToDoMainPage.ToDoRightMenuBelowButton);

    }

    @Step("Count The List")
    public static int getNumberOfTask(){
        return ToDoMainPage.ListOfTask.size();
    }

    @Step("Delete Task To The List")
    public static void DeleteList(){
        for (int i =0; i<getNumberOfTask();i++) {
            UIActions.MouseHover(ToDoMainPage.DeleteTask);
        }
    }

}
