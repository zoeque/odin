package zoeque.odin.domain.model;

/**
 * The enum class for choose setting column.
 */
public enum OdinSettingModel {
    /**
     * Use this enum with the getting preference file
     */
    SETTING("setting"),
    RANDOM_ORDER("random_order"),
    EXCEPT_LEARNED("except_learned");

    String settingModel;

    public String getSettingModel() {
        return this.settingModel;
    }

    OdinSettingModel(String settingModel) {
        this.settingModel = settingModel;
    }
}
