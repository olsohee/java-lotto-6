package lotto.domain.generator;

import java.util.List;

public interface NumberGenerator {

    List<Integer> generateRandomNumbers(int count);
}