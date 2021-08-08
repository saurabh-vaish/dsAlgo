package haffmanCoding;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 *  not working as expecetd
 *
 * @author Saurabh Vaish
 * @Date 27-06-2021
 */
public class HuffCodeEncodeDecodeFile {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("E:\\local\\thealgorists\\src\\main\\java\\haffmanCoding\\encodedFile.txt");

        StringBuffer str = new StringBuffer();
        Files.lines(path).forEach(str::append);

        HuffmanCode code = new HuffmanCode();
        List<Byte> list = code.getEncodedString(str.toString());

        Path writePath = Paths.get("E:\\local\\thealgorists\\src\\main\\java\\haffmanCoding\\decodedFile.txt");

        Files.deleteIfExists(writePath);
        Files.createFile(writePath);

        String decoded = code.decodeString(list);
        System.out.println(decoded);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        list.forEach(l->out.write(l));

        Files.write(writePath, out.toByteArray());



        BitSet.valueOf(out.toByteArray());

    }

}
