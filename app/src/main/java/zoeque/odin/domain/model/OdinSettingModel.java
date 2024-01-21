package zoeque.odin.domain.model;

/**
 * The enum class for choose setting column.
 */
public enum OdinSettingModel {
    /**
     * Use this enum with the getting preference file
     */
    SETTING("setting"),
    ODIN("zoeque_odin"),
    RANDOM_ORDER("random_order"),
    EXCEPT_LEARNED("except_learned"),
    LIST_SIZE("list_size"),
    LIST_IDX("list_idx"),
    LIST_STUDYING_IDX("list_studying_idx");

    String settingModel;

    public String getSettingModel() {
        return this.settingModel;
    }

    OdinSettingModel(String settingModel) {
        this.settingModel = settingModel;
    }
}
