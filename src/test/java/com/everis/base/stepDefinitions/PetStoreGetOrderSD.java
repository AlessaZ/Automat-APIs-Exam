package com.everis.base.stepDefinitions;

import com.everis.base.models.Order;
import com.everis.base.steps.PetStoreGetOrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;

public class PetStoreGetOrderSD {

    @Steps
    PetStoreGetOrderStep petStoreGetOrderStep;

    @Given("que estoy en la pagina")
    public void queEstoyEnLaPagina() {
    }

    @When("obtiene la orden con ID {int}")
    public void obtieneLaOrdenConIDId(int id) {
        petStoreGetOrderStep.consultarOrder(id);
    }

    @Then("verificar que el código de estado de la respuesta sea {int}")
    public void verificarQueElCódigoDeEstadoDeLaRespuestaSeaCode(int code) {
        petStoreGetOrderStep.validarCodigoRespuesta(code);
    }

    @And("la respuesta debe contener el id{int}, petId{int},quantity{int}")
    public void laRespuestaDebeContenerElIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        Order order = petStoreGetOrderStep.obtenerRespuestadeOrder();
        assertEquals(id,order.getId());
        assertEquals(petId,order.getPetId());
        assertEquals(quantity,order.getQuantity());
    }
}
