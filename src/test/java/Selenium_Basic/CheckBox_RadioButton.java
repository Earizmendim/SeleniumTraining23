package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox_RadioButton
{
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        Thread.sleep(2000);
    }

    //Validar:
    //1. Verificar que se muestre el elemento con el cual vamos a interactuar antes de cualquier operación
    //2. Verificar que los radio button o check esten habilitados
    //3. Verificar que la seleccion predeterminada del botón , ya sea radio o check

    @Test
    public void  CheckAndRadio() throws InterruptedException {
        WebElement radioButtonMale = driver.findElement(By.xpath("//input[@name='optradio' and @value='Male']"));

        //isDisplayed() : lo que nos regrese es un valor booleano, si devuelve verdadero entonces dicho botón esta presente
        // si es falso entonces el botón no esta presente

        /*boolean status = radioButtonMale.isDisplayed();
        System.out.println("Status: " + status);

        radioButtonMale.click();
        Thread.sleep(3000);*/

        //isEnable() : lo que nos regresa es un valor booleano, si devuelve verdadero entonces el boton esta habilitado,
        //si regresa falso entonces el boton no esta presente

        /*boolean statusDisplayed = radioButtonMale.isDisplayed();
        boolean statusEnable = radioButtonMale.isEnabled();
        System.out.println("Status Displayed: " + statusDisplayed);
        System.out.println("Status Enabled: " + statusEnable);*/

        //isSelected() : lo que nos regresa es un valor booleano, si devuelve verdadero entonces el boton esta seleccionado,
        //si regresa falso el boton no esta presente

        boolean statusDisplayed = radioButtonMale.isDisplayed();
        Thread.sleep(3000);

        boolean statusEnable = radioButtonMale.isEnabled();
        Thread.sleep(3000);

        boolean statusSelected = radioButtonMale.isSelected();
        Thread.sleep(3000);

        System.out.println("Status Displayed: " + statusDisplayed);
        System.out.println("Status Enabled: " + statusEnable);
        System.out.println("Status Selected: " + statusSelected);

        radioButtonMale.click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void TearDown()
    {
        //Cierra el navegador
        driver.close();
        //Para cerrar la instancia de Chrome desde administrador de tareas
        driver.quit();
    }
}