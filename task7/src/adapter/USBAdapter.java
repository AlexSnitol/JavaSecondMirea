package adapter;

public class USBAdapter extends USBTypeA {
    USBTypeC usbTypeC;

    public USBAdapter (USBTypeC usbTypeC) {
        this.usbTypeC = usbTypeC;
    }

    public void transferData() {
        this.usbTypeC.sendData();
    }
}
