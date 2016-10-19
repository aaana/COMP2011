package polyu.comp.datastructure.assign1;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by huanganna on 10/4/16.
 */
public class CourseRegistryUnsorted {
    int[][] students;
    int[] count;
    int labNum = 0;
    int labCapacity = 0;

    public CourseRegistryUnsorted(int labNum, int labCapacity) {
        this.labNum = labNum;
        this.labCapacity = labCapacity;
        count = new int[labNum];
        students = new int[labNum][labCapacity];

    }


    //无序数组的搜索
    public int[] search(int student) {
        for(int i=0;i<labNum;i++){
            for (int j = 0; j < labCapacity; j++)
                if (students[i][j] == student){
                    return new int[]{i,j};
                }
        }
        return null;
    }

    public int sum(){
        int sum = 0;
        for(int i=0;i<labNum;i++){
            sum += count[i];
        }
        return sum;
    }

    public boolean isFull(int lab){
        if(count[lab]>=labCapacity)
            return true;
        return false;

    }

    public boolean register(int student,int lab) {
        int[] LabPos = search(student);
        if (LabPos!=null) {
            System.out.println("You have registered for this course.");
//            System.out.println("You are in: (" +LabPos.labNum+","+LabPos.position+")");
            System.out.println("You are in: (" +LabPos[0]+","+LabPos[1]+")");

            return false;
        }
        if (isFull(lab)) {
            System.out.print("Lab"+lab+" is full. Please choose from the following labs:");
            for(int i=0;i<labNum;i++){
                if(i!=lab&&!isFull(i))
                    System.out.print(" "+i);
            }
            System.out.println();
            return false;
        }
        students[lab][count[lab]] = student;
        count[lab]++;
        System.out.println("Student " + student + " registered " +"in the Lab"+lab);
        return true;
    }

    public boolean drop(int student) {
        int[] pos = search(student);
        if (pos == null) {
            System.out.println("Student " + student + " was not registered.");
            return false;
        }
        int lab = pos[0];
        int position = pos[1];
        students[lab][position] = students[lab][count[lab]-1];
        students[lab][count[lab]-1] = 0;
        count[lab]--;
        System.out.println("Student " + student + " dropped.");
        return true;
    }

    public String toString() {
        String result= "";
        for(int i=0;i<labNum;i++){
            result += "Lab"+i+":"+ Arrays.stream(students[i], 0, count[i])
                    .mapToObj(Integer::toString).collect(Collectors.joining(", ")) +"\n";
        }

        return result;
    }

    public int[]merge(){
        int[] result = students[0];
        int resultCount = count[0];
        for(int i=1;i<labNum;i++){
            result = merge(result,resultCount,students[i],count[i]);
            resultCount +=count[i];
        }
        return result;
    }

    private int[] merge(int[]a,int countA,int[]b,int countB){
        int[] result = new int[countA+countB];
        int i = 0,j = 0,k = 0;
        while(i<countA)
            result[k++] = a[i++];
        while (j<countB)
            result[k++] = b[j++];
        return result;

    }

    public static void main(String[] args) {
//        final int CAPACITY = 140;
        CourseRegistryUnsorted comp2011 = new CourseRegistryUnsorted(5,31);
        int[] studentNos = { 15101317, 15101119, 15079132, 15093307, 15093733, 15072577, 15074725, 15104391, 15103709,
                15101964, 15100967, 15110455, 15093381, 15068106, 15065555, 15103136, 15101743, 15103691, 15100449,
                15101377, 15066186, 15103746, 14081983, 15103875, 15103113, 15101805, 15077145, 15068136, 15077182,
                15084296, 15084839, 14075113, 15090397, 15070086, 15092796, 14073522, 14073607, 15071336, 15081243,
                15082164, 15071732, 15083787, 14110951, 15093252, 15088583, 15084342, 15085065, 13103168, 15086863,
                15067031, 15070864, 15067779, 14110113, 15076735, 15084213, 15079834, 15079422, 15085447, 15089727,
                15067489, 15074198, 15071587, 15090381, 15080117, 15063255, 15075356, 15073415, 14077793, 15067703,
                14075723, 15069796, 14109998, 15071801, 15061473, 13104029, 15084945, 15066736, 15044919, 13105383,
                15076132, 14109533, 13104241, 15063347, 15079765, 14111285, 14111743, 15111284, 15048083, 15062997,
                15062051, 15089223, 14040525, 15011142, 15044827, 15070597, 15034865, 15011089, 15048053, 15083573,
                15053873, 15050378, 15011128, 15051131, 14075067, 15011135, 15065007, 15088378, 15102641, 15063545,
                15061528, 15062081, 15104292, 15050698, 16018978, 14020686, 13104013, 14075341, 16019015, 15078172,
                13102857, 15078386, 13102033, 16010922, 14074222, 16107864, 15074656, 16042701, 14073759, 13103693,
                16010938, 15066483, 15068387, 13114806, 16019008, 12131888, 15063476, 15076979, 15094136, 14110419, };

        for (int i = 0; i < studentNos.length;) {
            boolean isFull = true;
            for(int j=0;j<comp2011.labNum;j++){
                if(!comp2011.isFull(j)){
                    isFull = false;
                    break;
                }
            }

            if(isFull){
                System.out.println("All labs are full");
                break;
            }else{
                Random random = new Random();
                int s = random.nextInt(5);
                if(!comp2011.isFull(s)){
                    comp2011.register(studentNos[i],s);
                    i++;
                }
            }
        }
        System.out.println("The semester begins.");
        System.out.println(comp2011.sum() + " students register for COMP 2011:\n" + comp2011);
        comp2011.register(13103831, 1);
        comp2011.register(12131927, 1);
        System.out.println("The registry is finalized.");
        System.out.println(comp2011.sum() + " students register for COMP 2011:\n" + comp2011);
        int[] result = comp2011.merge();
        for(int i=0;i<result.length;i++)
            System.out.println(result[i]);
        System.out.println(result.length);
    }
}
