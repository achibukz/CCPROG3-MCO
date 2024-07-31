package Controllers;

import Views.*;
import Models.*;
import Controllers.*;


public class mainController {
    private HRSys model;
    private HRGui hrgui;
    private createGUI creategui;
    private viewGui viewgui;
    private manGui mangui;
    private bookGui bookgui;

    private addRoom addRoomView;
    private dataPrice dataPriceView;
    private highLev highLevView;
    private lowLev lowLevView;
    private remHot remHotView;
    private remRes remResView;
    private remRoom remRoomView;
    private updBasePrice updBasePriceView;
    private updHotName updHotNameView;

    // private RoomAvail roomAvailView;
    // private RoomInfo roomInfoView;
    // private ReservView reservView;

    private hrCont hrCont;
    private viewCont viewCont;
    private manCont manCont;
    private bookCont bookCont;
    private addRoomCont addRoomCont;
    private dataPriceCont dataPriceCont;
    private highLevCont highLevCont;
    private lowLevCont lowLevCont;
    private remHotCont remHotCont;
    private remResCont remResCont;
    private remRoomCont remRoomCont;
    private updBasePriceCont updBasePriceCont;
    private updHotCont updHotCont;
    private creCont creCont;

    // private RoomAvailCont roomAvailCont;
    // private RoomInfoCont roomInfoCont;
    // private ReservCont reservCont;
    private Hotel name;
    private String hotelName;

    public mainController(){
        model = new HRSys();

        creategui = new createGUI();
        creCont = new creCont(model, creategui, this);

        
        // MAIN
        // hrgui = new HRGui(hotelName);
        // hrCont = new hrCont(model, hrgui, creategui, name, this);

        // viewgui = new viewGui();
        // viewCont = new viewCont(model, viewgui, hrgui, name, this);

        // mangui = new manGui();
        // manCont = new manCont(model, mangui, hrgui, name, this);
        // System.out.println("-----------------------");

        // bookgui = new bookGui();
        // bookCont = new bookCont(model, bookgui, hrgui, name, this);
        // System.out.println("-----------------------");

        // // Manage
        // updHotNameView = new updHotName();
        // updHotCont = new updHotCont(model, updHotNameView, mangui, name, this);

        // addRoomView = new addRoom();
        // addRoomCont = new addRoomCont(model, addRoomView, mangui, name, this);

        // remRoomView = new remRoom();
        // remRoomCont = new remRoomCont(model, remRoomView, mangui, name, this);

        // updBasePriceView = new updBasePrice();
        // updBasePriceCont = new updBasePriceCont(model, updBasePriceView, mangui, name, this);

        // remResView = new remRes();
        // remResCont = new remResCont(model, remResView, mangui, name, this);

        // remHotView = new remHot();
        // remHotCont = new remHotCont(model, remHotView, mangui, name, this);

        // dataPriceView = new dataPrice();
        // dataPriceCont = new dataPriceCont(model, dataPriceView, mangui, name, this);

        // // View
        // lowLevView = new lowLev();
        // lowLevCont = new lowLevCont(model, lowLevView, viewgui, name, this);

        // highLevView = new highLev();
        // highLevCont = new highLevCont(model, highLevView, viewgui, name, this);

        creategui.setVisible(true);
    }

    public void setName(Hotel name) {
        System.out.println("Setting new hotel: " + name);
        this.name = name;
        updateControllers();
    }



    

    public void updateControllers(){
        hrCont.setName(name);
        viewCont.setName(name);
        manCont.setName(name);
        bookCont.setName(name);
        // addRoomCont.setName(name);
        // dataPriceCont.setName(name);
        // highLevCont.setName(name);
        // lowLevCont.setName(name);
        // remHotCont.setName(name);
        // remResCont.setName(name);
        // remRoomCont.setName(name);
        // updBasePriceCont.setName(name);
        updHotCont.setName(name);
        //creCont.setName(name);
    }

    public HRGui getHRGui(){
        return hrgui;
    }

    public createGUI getCreateGUI(){
        return creategui;
    }

    public viewGui getViewGui(){
        return viewgui;
    }

    public manGui getManGui(){
        return mangui;
    }

    public bookGui getBookGui(){
        return bookgui;
    }

    public addRoom getAddRoomView(){
        return addRoomView;
    }

    public dataPrice getDataPriceView(){
        return dataPriceView;
    }

    public highLev getHighLevView(){
        return highLevView;
    }

    public lowLev getLowLevView(){
        return lowLevView;
    }

    public remHot getRemHotView(){
        return remHotView;
    }

    public remRes getRemResView(){
        return remResView;
    }

    public remRoom getRemRoomView(){
        return remRoomView;
    }

    public updBasePrice getUpdBasePriceView(){
        return updBasePriceView;
    }

    public updHotName getUpdHotNameView(){
        return updHotNameView;
    }

    public hrCont getHRCont(){
        return hrCont;
    }

    public viewCont getViewCont(){
        return viewCont;
    }

    public manCont getManCont(){
        return manCont;
    }

    public bookCont getBookCont(){
        return bookCont;
    }

    public addRoomCont getAddRoomCont(){
        return addRoomCont;
    }

    public dataPriceCont getDataPriceCont(){
        return dataPriceCont;
    }

    public highLevCont getHighLevCont(){
        return highLevCont;
    }

    public lowLevCont getLowLevCont(){
        return lowLevCont;
    }

    public remHotCont getRemHotCont(){
        return remHotCont;
    }

    public remResCont getRemResCont(){
        return remResCont;
    }

    public remRoomCont getRemRoomCont(){
        return remRoomCont;
    }

    public updBasePriceCont getUpdBasePriceCont(){
        return updBasePriceCont;
    }

    public updHotCont getUpdHotCont(){
        return updHotCont;
    }

    public creCont getCreCont(){
        return creCont;
    }

    public String getName(){
        return name;
    }

    public void setHrCont(hrCont hrCont) {
        this.hrCont = hrCont;
    }

    public void setViewCont(viewCont viewCont) {
        this.viewCont = viewCont;
    }

    public  void setManCont(manCont manCont) {
        this.manCont = manCont;
    }

    public void setBookCont(bookCont bookCont) {
        this.bookCont = bookCont;
    }


}
