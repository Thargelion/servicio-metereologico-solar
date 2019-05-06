package lib.mongo;

import com.mongodb.client.model.ReplaceOptions;

public enum ReplaceOptionsEnum {
    UPSERT(buildUpsert());
    ReplaceOptions replaceOptions;
    ReplaceOptionsEnum(ReplaceOptions replaceOptions) {
        this.replaceOptions = replaceOptions;
    }

    public ReplaceOptions getReplaceOptions() {
        return replaceOptions;
    }

    private static ReplaceOptions buildUpsert() {
        ReplaceOptions replaceOptions = new ReplaceOptions();
        replaceOptions.upsert(true);
        return replaceOptions;
    }
}
