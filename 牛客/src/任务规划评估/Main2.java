package 任务规划评估;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
2
{"counterName":"A","taskId":1,"taskType":3}
{"counterName":"A","taskId":2,"taskType":21}
{"counterName":"A","taskId":3,"taskType":3}
{"counterName":"B","taskId":4,"taskType":10}
{"counterName":"C","taskId":5,"taskType":11}
{"counterName":"C","taskId":6,"taskType":4}

[7, 1, 4]
 */
// 20 任务规划评估
public class Main2 {

    /**
     * 任务类
     * 【无需改动】
     */
    static class Task {
        //任务id
        Long taskId;
        //货柜名称
        String counterName;
        //配送任务类型=子任务类型之和
        Long taskType;

        public Task() {
        }

        public Long getTaskId() {
            return taskId;
        }

        public void setTaskId(Long taskId) {
            this.taskId = taskId;
        }

        public Long getTaskType() {
            return taskType;
        }

        public void setTaskType(Long taskType) {
            this.taskType = taskType;
        }

        public String getCounterName() {
            return counterName;
        }

        public void setCounterName(String counterName) {
            this.counterName = counterName;
        }
    }

    /**
     * 将输入的字符串任务转换为任务类的对象
     * 【无需改动】
     *
     * @param taskStr
     * @return
     */
    private static Task convertToTask(String taskStr) {
        String cleanTask = taskStr.substring(1, taskStr.length() - 1);
        String[] vars = cleanTask.split(",");
        String[] nameStr = vars[0].split(":");
        String[] taskIdStr = vars[1].split(":");
        String[] typeStr = vars[2].split(":");
        Task task = new Task();
        task.setCounterName(nameStr[1]);
        task.setTaskId(Long.parseLong(taskIdStr[1]));
        task.setTaskType(Long.parseLong(typeStr[1]));
        return task;
    }

    /**
     * ACM模式输入输出处理【无需改动】
     *
     * @param args
     */
    public static void main(String[] args) {
        //ACM模式输入
        Scanner in = new Scanner(System.in);
        List<Task> strArr = new ArrayList<>();
        int i = 0;
        int k = 0;
        while (in.hasNext()) {
            if (i == 0) {
                k = Integer.parseInt(in.nextLine());
            } else {
                strArr.add(convertToTask(in.nextLine()));
            }
            i++;
        }
        //题目逻辑计算
        int[] res = planTasks(strArr, k);
        //ACM模式输出
        System.out.println(Arrays.toString(res));
    }

    /**
     * 任务规划评估
     *
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param tasks 要规划的任务列表
     * @param k     间隔的天数
     * @return 一个数组a[], 比如[10,2,3] a[0]即10为做完最少的天数， a[1]即2为空闲的天数，a[2]即3为2k天内完成的校期子任务数量，
     */
    public static int[] planTasks(List<Task> tasks, int k) {
        //todo 请实现此函数
        int qiaoQI=0;
        for (Task task : tasks) {
            if((task.taskType&2)==2){
                qiaoQI++;
            }
        }
        return new int[]{tasks.size(),0,qiaoQI};
    }



    static void dsf(List<Task> tasks,boolean[] vis){

    }

}