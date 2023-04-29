import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        String binary = Integer.toBinaryString(number);
        List<Signal> res = new ArrayList<>();

        int i = Integer.parseInt(binary);

        if (i % 10 == 1) res.add(Signal.WINK);
        if (i / 10 % 10 == 1) res.add(Signal.DOUBLE_BLINK);
        if (i / 100 % 10 == 1) res.add(Signal.CLOSE_YOUR_EYES);
        if (i / 1000 % 10 == 1) res.add(Signal.JUMP);
        if (i / 10000 % 10 == 1) Collections.reverse(res);

        return res;
    }
}
