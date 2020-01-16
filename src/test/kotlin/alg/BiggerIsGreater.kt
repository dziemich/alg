package alg

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BiggerIsGreater {

  @Test
  fun test1(){

    val biggerIsGreater = biggerIsGreater("ab")
    Assertions.assertEquals("ba", biggerIsGreater)
  }

  @Test
  fun test2(){
    val biggerIsGreater = biggerIsGreater("bb")
    Assertions.assertEquals("no answer", biggerIsGreater)
  }

  @Test
  fun test3(){

    val biggerIsGreater = biggerIsGreater("hefg")
    Assertions.assertEquals("hegf", biggerIsGreater)
  }

  @Test
  fun test4(){
    val biggerIsGreater = biggerIsGreater("dhck")
    Assertions.assertEquals("dhkc", biggerIsGreater)
  }

  @Test
  fun test5(){
    val biggerIsGreater = biggerIsGreater("dkhc")
    Assertions.assertEquals("hcdk", biggerIsGreater)
  }
}
