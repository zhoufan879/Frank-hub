package frank.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.commons.codec.binary.Base64;

public class ZipUtils {
	
	public static void main(String[] args) {
		String s = "0001AB92830109123456 0001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB928301091234560001AB92830109123456";
		s += s;
		s += s;
		
		String s2 = s;
		
		long begin = System.currentTimeMillis();
		long end;
		
//		System.out.println("ZIP压缩前： " + s.length() + "  " + s );
//		s = zip(s);
//		System.out.println("ZIP压缩后： " + s.length() + "  " + s);
//
//		end = System.currentTimeMillis();
//		System.out.println("耗时： " + (end-begin)+"ms");
		
		long begin2 = System.currentTimeMillis();
		System.out.println("GZIP压缩前： " + s2.length() + "  " + s2);
		s2 = gzip(s2);
		System.out.println("GZIP压缩后： " + s2.length() + "  " + s2);
		long end2 = System.currentTimeMillis();
		System.out.println("耗时： " + (end2-begin2)+"ms");
	}

    /**
     * 
     * 使用gzip进行压缩
     */
    public static String gzip(String primStr) {
        if (primStr == null || primStr.length() == 0) {
            return primStr;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(primStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return new String(new Base64().encode(out.toByteArray()));
    }

    /**
     * 使用gzip进行解压缩
     * @param compressedStr
     * @return 解压后的字符串
     */
    public static String gunzip(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream ginzip = null;
        byte[] compressed = null;
        String decompressed = null;
        try {
            compressed = new Base64().decode(compressedStr.getBytes());
            in = new ByteArrayInputStream(compressed);
            ginzip = new GZIPInputStream(in);

            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ginzip != null) {
                try {
                    ginzip.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }

        return decompressed;
    }

    /**
     * 使用zip进行压缩
     * 
     * @param str
     *            压缩前的文本
     * @return 返回压缩后的文本
     */
    public static final String zip(String str) {
        if (str == null)
            return null;
        byte[] compressed;
        ByteArrayOutputStream out = null;
        ZipOutputStream zout = null;
        String compressedStr = null;
        try {
            out = new ByteArrayOutputStream();
            zout = new ZipOutputStream(out);
            zout.putNextEntry(new ZipEntry("0"));
            zout.write(str.getBytes());
            zout.closeEntry();
            compressed = out.toByteArray();
            compressedStr = new String(new Base64().encode(compressed));
        } catch (IOException e) {
            compressed = null;
        } finally {
            if (zout != null) {
                try {
                    zout.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return compressedStr;
    }

    /**s
     * 使用zip进行解压缩
     * 
     * @param compressed
     *            压缩后的文本
     * @return 解压后的字符串
     */
    public static final String unzip(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }

        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        ZipInputStream zin = null;
        String decompressed = null;
        try {
            byte[] compressed = new Base64().decode(compressedStr.getBytes());
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(compressed);
            zin = new ZipInputStream(in);
            zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = zin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            decompressed = null;
        } finally {
            if (zin != null) {
                try {
                    zin.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return decompressed;
    }
}
