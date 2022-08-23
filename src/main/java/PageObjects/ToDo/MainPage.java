package PageObjects.ToDo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(how = How.CSS, using ="input[placeholder='Create a task']")
    public WebElement CreateATask;

    @FindBy(how = How.CLASS_NAME, using ="view_2Ow90")
    public List<WebElement> ListOfTask;

    @FindBy(how = How.CLASS_NAME, using ="allCompletedWrapper_wdM4q")
    public WebElement ToggleAllCompleted;

    @FindBy(how = How.CLASS_NAME, using ="destroy_19w1q")
    public WebElement DeleteTask;

    @FindBy(how = How.CLASS_NAME, using ="toggleVisibilityPanel_hNPyc")
    public WebElement RightMenuBelow;

    @FindBy(how = How.XPATH, using ="/html/body/div/div[2]/div[2]/div/div/div[3]/button[2]")
    public WebElement ToDoRightMenuBelowButton;

    @FindBy(how = How.XPATH, using ="/html/body/div/div[2]/div[2]/div/div/div[3]/button[1]")
    public WebElement AllRightMenuBelowButton;


}
