package com.sucy.skill.util.io.parser

import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

/**
 * SkillAPIKotlin © 2018
 */
class YAMLParserTest {
    private val subject = YAMLParser()

    @Test
    fun parseBasic() {
        testFile("flat")
        testFile("tiered")
        testFile("lists")
        testFile("commented")
        testFile("quoted")
        testFile("complex")
    }

    fun testFile(file: String) {
        val data = File("test-files/yaml/$file.yml").readText()
        val result = subject.parse(data)
        val restored = subject.serialize(result)

        val out = File("test-output/yaml/$file.yml")
        out.parentFile.mkdirs()
        out.writeText(restored)

        assertEquals(data.lines(), restored.lines())
    }
}