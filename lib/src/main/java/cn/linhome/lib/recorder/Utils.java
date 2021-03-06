package cn.linhome.lib.recorder;

import java.io.File;

class Utils
{
    public static File createDefaultFileUnderDir(File dir, String ext)
    {
        try
        {
            if (ext == null)
            {
                ext = "";
            }

            long current = System.currentTimeMillis();
            File file = new File(dir, String.valueOf(current + ext));
            while (file.exists())
            {
                current++;
                file = new File(dir, String.valueOf(current + ext));
            }
            return file;
        } catch (Exception e)
        {
            return null;
        }
    }

    public static boolean deleteFileOrDir(File path)
    {
        if (path == null || !path.exists())
        {
            return true;
        }
        if (path.isFile())
        {
            return path.delete();
        }
        File[] files = path.listFiles();
        if (files != null)
        {
            for (File file : files)
            {
                deleteFileOrDir(file);
            }
        }
        return path.delete();
    }
}
