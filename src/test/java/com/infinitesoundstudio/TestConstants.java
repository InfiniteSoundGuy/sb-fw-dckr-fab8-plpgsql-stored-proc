package com.infinitesoundstudio;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public interface TestConstants {

    Instant START_DATE = Instant.now().minus(1, ChronoUnit.HOURS);
    Instant END_DATE = Instant.now().plus(1, ChronoUnit.HOURS);

    String LABEL1 = "label1";
    String PROP_ID1 = "propId1";

    String LABEL2 = "label2";
    String PROP_ID2 = "propId2";

    String LABEL3 = "label3";
    String PROP_ID3 = "propId3";

    String LABEL4 = "label4";
    String PROP_ID4 = "propId4";

    String LABEL5 = "label5";
    String PROP_ID5 = "propId5";

    String[] LABELS = {LABEL1, LABEL2, LABEL3, LABEL4, LABEL5};
    String[] PROP_IDS = {PROP_ID1, PROP_ID2, PROP_ID3, PROP_ID4, PROP_ID5};

}
