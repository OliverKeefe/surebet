package org.surebet;

import java.util.HashMap;

public abstract class DataAssembler {

    public DataAssembler() {}

    /*TODO: Refactor data-service so that classes are more specific.
     Should have one class to scrape data, another to assemble them into
     organised betting markets, then finally another to add to database.

     Would've done this sooner but I spent an inordinate amount of time
     exploring, in hindsight, really weird methods to implement this.
     * **/
    public abstract HashMap<String, String> marketAssemble();
}
