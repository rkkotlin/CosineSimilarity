package com.fourcircles.cosine.similarity.helpers

import com.fourcircles.cosine.similarity.service.CosineSimScoreService
import org.junit.jupiter.api.Test

class VectorHelperTest {
   private var vectorHelper: VectorHelper = VectorHelper()

    var wordsOccurenceSource1: HashMap<String, Int> = HashMap()
    var wordsOccurenceSource2: HashMap<String, Int> = HashMap()

    @Test
    fun `create vector from source`() {
        val source = "chef who made his early rep creating adventurous that pushes the same expert meals each evening "
        val wordVector = vectorHelper.splitString(source)
        println(wordVector.first().toString())
    }

    @Test
    fun `test robert downey jr film picks up from avengers`() {

        wordsOccurenceSource1 =
            vectorHelper.createVectorFromText("Detective Sherlock Holmes and his stalwart partner Watson engage in a battle of wits and brawn with a nemesis whose plot is a threat to all of England. fiction, detective rich robert downey mystery")
        wordsOccurenceSource2 =
            vectorHelper.createVectorFromText("After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil. fiction, robert downey rich mystery ")
        println(" cosine similarity = " + CosineSimScoreService.computeSimilarity(wordsOccurenceSource1,wordsOccurenceSource2) )

    }

  @Test
  fun `test he or she likes avengers' movies`() {
    wordsOccurenceSource1 = vectorHelper.createVectorFromText("He likes Avengers’ movies")
    wordsOccurenceSource2 = vectorHelper.createVectorFromText("She likes Avengers’ movies")
      println(" cosine similarity = " + CosineSimScoreService.computeSimilarity(wordsOccurenceSource1,wordsOccurenceSource2) )
  }
}