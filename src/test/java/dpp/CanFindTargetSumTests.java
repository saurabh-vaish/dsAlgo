package dpp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * @author Saurabh Vaish
 * @Date 01-08-2021
 */
public class CanFindTargetSumTests {


    @ParameterizedTest
    @ValueSource(ints = {7,20,35,50})
    public void testCanSum(int targetSum){
        int ar[] = {2,5,4,7};
        boolean exists = CanFindTargetSum.canSum(ar, targetSum);
        System.out.println(exists);
    }

}
