package promotionCodeGen;

import Interfaces.GeneralRoom;
import Interfaces.User;

import java.util.Random;

public class PromotionCodeGenerator {
    private final User user;
    private String code;

    public PromotionCodeGenerator(User user) {
        this.user = user;
        if (user.getReceipts().size() > 5) {
            this.code = genCode();
            System.out.println("Промо код за потребителя: " + code);
        }
    }

    public String genCode() {
        int length = 8;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }

    public String getCode() {
        return code;
    }
}
