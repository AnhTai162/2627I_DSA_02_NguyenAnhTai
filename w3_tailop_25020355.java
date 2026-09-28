import java.util.Stack;

public class w3_tailop_25020355 {
    static int doUuTien(char phepToan) {
        if (phepToan == '+' || phepToan == '-') {
            return 1;
        }
        if (phepToan == '*' || phepToan == '/') {
            return 2;
        }
        return -1;
    }

    static String trungToSangHauTo(String bieuThuc) {
        StringBuilder ketQua = new StringBuilder();
        Stack<Character> nganXep = new Stack<>();

        for (int i = 0; i < bieuThuc.length(); i++) {
            char kyTu = bieuThuc.charAt(i);

            if (Character.isLetterOrDigit(kyTu)) {
                ketQua.append(kyTu);
            } else if (kyTu == '(') {
                nganXep.push(kyTu);
            } else if (kyTu == ')') {
                while (!nganXep.isEmpty() && nganXep.peek() != '(') {
                    ketQua.append(nganXep.pop());
                }
                nganXep.pop();
            } else {
                while (!nganXep.isEmpty() && doUuTien(kyTu) <= doUuTien(nganXep.peek())) {
                    ketQua.append(nganXep.pop());
                }
                nganXep.push(kyTu);
            }
        }

        while (!nganXep.isEmpty()) {
            ketQua.append(nganXep.pop());
        }

        return ketQua.toString();
    }

    public static void main(String[] args) {
        String bieuThuc = "20-(5+2)*1*3-2*(3+1)";
        System.out.println(trungToSangHauTo(bieuThuc));
    }
}