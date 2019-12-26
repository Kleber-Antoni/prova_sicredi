package tests;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import sun.plugin.javascript.navig.Link;
import java.util.List;

public class provaAutomacaoTest {
    private WebDriver navegador;
    @Before
    public void setUp(){
        //Acessessando a página https://www.grocerycrud.com/demo/bootstrap_theme
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kleber\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.get("https://www.grocerycrud.com/demo/bootstrap_theme");
    }

    @Test
    public void testDesafio1 () throws InterruptedException {
        // Mudando a versão para "Bootstrap V4 Theme"
        WebElement versao = navegador.findElement(By.id("switch-version-select"));
        versao.findElement(By.xpath("//*[@id=\"switch-version-select\"]/option[2]")).click();

        // Clicando em Add Customer
        navegador.findElement(By.linkText("Add Customer")).click();
            //Preenchendo os campos do formulário
            WebElement formulario = navegador.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]"));
    //        • Name: Teste Sicredi
            formulario.findElement(By.id("field-customerName")).sendKeys("Teste_sicredi");
    //        • Last name: Teste
            formulario.findElement(By.id("field-contactLastName")).sendKeys("Teste");
    //        • ContactFirstName: seu nome
            formulario.findElement(By.id("field-contactFirstName")).sendKeys("Kleber Luis de Antoni Rocha");
    //        • Phone: 51 9999-9999
            formulario.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
    //        • AddressLine1: Av Assis Brasil, 3970
            formulario.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
    //        • AddressLine2: Torre D
            formulario.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
    //        • City: Porto Alegre
            formulario.findElement(By.id("field-city")).sendKeys("Porto Alegre");
    //        • State: RS
            formulario.findElement(By.id("field-state")).sendKeys("RS");
    //        • PostalCode: 91000-000
            formulario.findElement(By.id("field-postalCode")).sendKeys("91000-000");
    //        • Country: Brasil
            formulario.findElement(By.id("field-country")).sendKeys("Brasil");
            JavascriptExecutor jse = (JavascriptExecutor)navegador;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    //        • from Employeer: Fixter
            formulario.findElement(By.id("field_salesRepEmployeeNumber_chosen")).click();
            formulario.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input")).sendKeys("Fixter");
            formulario.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/ul/li")).click();
    //        • CreditLimit: 200
            formulario.findElement(By.id("field-creditLimit")).sendKeys("200");

        // Clicando no botão Save
        formulario.findElement(By.id("form-button-save")).click();

        //Validando a mensagem "Your data has been successfully stored into the database." através de uma asserção
        Thread.sleep(3000); // Aguardando o campo com a mensagem ficar disponível
        WebElement texto = formulario.findElement(By.xpath("//*[@id=\"report-success\"]/p"));
        String retorno = texto.getText(); // Salvnado em uma variável o texto da mensagem
        assertEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list",retorno); // Realizando a validação da mensagem
    }

    @Test
    public void testDesafio2 () throws InterruptedException {
        //Realizando o Desafio 1.
        WebElement versao = navegador.findElement(By.id("switch-version-select"));
        versao.findElement(By.xpath("//*[@id=\"switch-version-select\"]/option[2]")).click();
        navegador.findElement(By.linkText("Add Customer")).click();
            WebElement formulario = navegador.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]"));
            formulario.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
            formulario.findElement(By.id("field-contactLastName")).sendKeys("Teste");
            formulario.findElement(By.id("field-contactFirstName")).sendKeys("Kleber Luis de Antoni Rocha");
            formulario.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
            formulario.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
            formulario.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
            formulario.findElement(By.id("field-city")).sendKeys("Porto Alegre");
            formulario.findElement(By.id("field-state")).sendKeys("RS");
            formulario.findElement(By.id("field-postalCode")).sendKeys("91000-000");
            formulario.findElement(By.id("field-country")).sendKeys("Brasil");
            JavascriptExecutor jse = (JavascriptExecutor)navegador;
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            formulario.findElement(By.id("field_salesRepEmployeeNumber_chosen")).click();
            formulario.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input")).sendKeys("Fixter");
            formulario.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/ul/li")).click();
            formulario.findElement(By.id("field-creditLimit")).sendKeys("200");
            formulario.findElement(By.id("form-button-save")).click();
        Thread.sleep(3000);
        WebElement texto = formulario.findElement(By.xpath("//*[@id=\"report-success\"]/p"));
        String retorno = texto.getText();
        assertEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list",retorno);

//        1. Selecionando o link Go back to list
        texto.findElement(By.linkText("Go back to list")).click();

//        2. Efetuando a pesquisa na lupa  pelo Name (Teste Sicredi)
        WebElement buscar = navegador.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]"));
        buscar.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]")).click();
        buscar.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]/input")).sendKeys("Teste Sicredi");
        buscar.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]/i[1]")).click();

//        3. Clicar no checkbox abaixo da palavra Actions
        navegador.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]/div/input")).click();

//        4. Clicar no botão Delete
        Thread.sleep(3000);
        navegador.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a/span")).click();

//        5. Validar o texto "Are you sure that you want to delete this 1 item?" através de uma asserção para a popup que será apresentada
        Thread.sleep(3000);
        WebElement popup2 = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div"));
        String textPopup2 = popup2.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]")).getText();
        assertEquals("Are you sure that you want to delete this 1 item?",textPopup2);

//        6. Clicar no botão Delete da popup
        popup2.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")).click();

//        7. Aparecerá uma mensagem dentro de um box verde na parte superior direito da tela. Adicione uma asserção na mensagem "Your data has been successfully deleted from the database."
        Thread.sleep(3000);
        WebElement retornoDelete = navegador.findElement(By.xpath("/html/body/div[3]"));
        String textoDelete = retornoDelete.findElement(By.xpath("/html/body/div[3]/span[3]/p")).getText();
        assertEquals("Your data has been successfully deleted from the database.", textoDelete);
    }

    @After
    public void tearDow(){
        //Feche o browser web
        navegador.quit();
    }
}
