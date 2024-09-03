package commercial.bankingapplication.Models;

import commercial.bankingapplication.Views.ViewFactory;

public class Model {
    private final ViewFactory viewFactory;
    private static Model model;

    private Model(){
        this.viewFactory = new ViewFactory();
    }

    //create an instance of Model class if it has not already been created
    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    // return the ViewFactory object that was created to call the views for the application
    public ViewFactory getViewFactory(){
        return viewFactory;
    }
}
