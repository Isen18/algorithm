import java.io.*;

/**
 * @author Isen
 * @date 2021/3/13 10:29
 * @since 1.0
 */
public class Test3 {
    // 当前读取进度
    private static int[] curNums = new int[10];
    private static int curNumsSize = 0;
    private static int curNumsReadPoint = 0;

    public static void main(String[] args) {
        //获取最大的n个数
        int[] topNs = topN(100, "xxx.txt");
    }

    private static int[] topN(int n, String filePath) {
        File file = new File(filePath);
        //xxx 可能需要对大文件进行拆分处理
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader((fileReader));

            int[] arr = new int[n + 1];
            //1. 读取前100个数字
            for (int i = 1; i < n + 1; i++) {
                Integer curNum = readNumFromFile(bufferedReader);
                if (curNum == null) {
                    return of(arr, i);
                }
                arr[i] = curNum;
            }

            //2. 构建小根堆
            buildMinHeap(arr, n);

            //3. 循环读取100个之后的数字
            while (true) {
                Integer curNum = readNumFromFile(bufferedReader);
                if (curNum == null) {
                    return of(arr, n + 1);
                }
                if (curNum > arr[1]) {
                    arr[1] = curNum;
                    shift(arr, n);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            //异常
            return new int[]{};
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static int[] of(int[] arr, int size) {
        int[] res = new int[size - 1];
        for (int i = 0; i < size - 1; i++) {
            res[i] = arr[i + 1];
        }

        return res;
    }

    private static Integer readNumFromFile(BufferedReader bufferedReader) throws IOException {
        //0. 获取当前读取进度，如果还有未读取的数字，则直接返回
        if (curNumsReadPoint < curNumsSize - 1) {
            return curNums[++curNumsReadPoint];
        }

        //1. 读取新行
        String line = bufferedReader.readLine();
        if (line == null) {
            return null;
        }

        //2. 行切割并保存
        String[] strs = line.split(",");
        curNumsSize = Math.min(strs.length, 10);
        for (int i = 0; i < curNumsSize; i++) {
            curNums[i] = Integer.parseInt(strs[i]);
        }
        curNumsReadPoint = 0;
        return curNums[curNumsReadPoint];
    }

    private static void shift(int[] arr, int end) {
        int i = 1;
        int j = i << 1;
        int base = arr[1];
        while (j <= end) {
            if (j < end && arr[j] > arr[j + 1]) {
                //j指向最小的孩子
                j++;
            }

            if (base > arr[j]) {
                //孩子节点上浮
                arr[i] = arr[j];
                i = j;
                j = i << 1;
            }
        }

        arr[i] = base;
    }

    private static void buildMinHeap(int[] arr, int end) {
        for (int i = end >> 1; i >= 1; i--) {
            shift(arr, i);
        }
    }
}
