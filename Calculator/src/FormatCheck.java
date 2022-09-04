class FormatCheck {
    enum RomeNumbers {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
        private int rome;

        RomeNumbers(int rome) {
            this.rome = rome;
        }
    }

    void formatCheck(String s, String[] qwe) {
        if (qwe.length != 3) {
            throw new IllegalArgumentException("В выражение должно быть не более 2 знаков \"пробел\"");
        }

        try {
            if (Integer.parseInt(qwe[0]) < 0 || Integer.parseInt(qwe[0]) > 10 ||
                    Integer.parseInt(qwe[2]) < 0 || Integer.parseInt(qwe[2]) > 10) {
                throw new IllegalArgumentException("Значения операндов не входят в диапазон допустимых значений");
            }
        } catch (Exception e1) {
            try {
                RomeNumbers.valueOf(qwe[0]);
                RomeNumbers.valueOf(qwe[2]);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Значения операндов не входят в диапазон допустимых значений");
            }
        }
    }
}