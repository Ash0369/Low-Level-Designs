public enum RuppeeType {
    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20),
    FIFTY(50), ONE_HUNDRED(100);
    private int value;
    RuppeeType(int value) {
        this.value = value;
    }

    public static RuppeeType fromValue(int value) {
        for (RuppeeType type : RuppeeType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

    public static boolean isAvailable(int value) {
        for (RuppeeType type : RuppeeType.values()) {
            if (type.value == value) {
                return true;
            }
        }
        return false;
    }
}
