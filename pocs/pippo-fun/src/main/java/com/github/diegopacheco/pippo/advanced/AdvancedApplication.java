package com.github.diegopacheco.pippo.advanced;

import ro.pippo.controller.ControllerApplication;

public class AdvancedApplication extends ControllerApplication {

    @Override
    protected void onInit() {
        addControllers(ContactsController.class); // one instance for EACH request
        addControllers(new ContactsController()); // one instance for ALL requests
        addControllers(FilesController.class);
    }

}
