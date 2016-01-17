package pl.dmichalski.reservations.business.ui.main_menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.dmichalski.reservations.business.ui.address.controller.AddressController;
import pl.dmichalski.reservations.business.ui.main_menu.view.MainMenuFrame;
import pl.dmichalski.reservations.business.ui.payment.controller.PaymentController;
import pl.dmichalski.reservations.business.ui.payment_method.controller.PaymentMethodController;
import pl.dmichalski.reservations.business.ui.reservation.controller.ReservationController;
import pl.dmichalski.reservations.business.ui.reservation_status.controller.ReservationStatusController;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.ui.client.controller.ClientController;

@Controller
public class MainMenuController extends AbstractFrameController {

    private MainMenuFrame mainMenuFrame;
    private AddressController addressController;
    private ClientController clientController;
    private ReservationStatusController reservationStatusController;
    private PaymentMethodController paymentMethodController;
    private PaymentController paymentController;
    private ReservationController reservationController;

    @Autowired
    public MainMenuController(MainMenuFrame mainMenuFrame,
                              AddressController addressController,
                              ClientController clientController,
                              ReservationStatusController reservationStatusController,
                              PaymentMethodController paymentMethodController,
                              PaymentController paymentController,
                              ReservationController reservationController) {
        this.mainMenuFrame = mainMenuFrame;
        this.addressController = addressController;
        this.clientController = clientController;
        this.reservationStatusController = reservationStatusController;
        this.paymentMethodController = paymentMethodController;
        this.paymentController = paymentController;
        this.reservationController = reservationController;
    }

    public void prepareAndOpenFrame() {
        registerAction(mainMenuFrame.getClientBtn(), (e) -> openClientsWindow());
        registerAction(mainMenuFrame.getAddressesBtn(), (e) -> openAddressWindow());
        registerAction(mainMenuFrame.getReservationStatusBtn(), (e) -> openReservationStatusWindow());
        registerAction(mainMenuFrame.getPaymentMethodBtn(), (e) -> openPaymentMethodWindow());
        registerAction(mainMenuFrame.getPaymentBtn(), (e) -> openPaymentWindow());
        registerAction(mainMenuFrame.getReservationBtn(), (e) -> openReservationWindow());
        mainMenuFrame.setVisible(true);
    }

    private void openAddressWindow() {
        addressController.prepareAndOpenFrame();
    }

    private void openClientsWindow() {
        clientController.prepareAndOpenFrame();
    }

    private void openReservationStatusWindow() {
        reservationStatusController.prepareAndOpenFrame();
    }

    private void openPaymentMethodWindow() {
        paymentMethodController.prepareAndOpenFrame();
    }

    private void openPaymentWindow() {
        paymentController.prepareAndOpenFrame();
    }

    private void openReservationWindow() {
        reservationController.prepareAndOpenFrame();
    }

}
