package polyu.comp.datastructure;

/**
 * Created by huanganna on 9/30/16.
 */
public class RemoveAdjacentDuplicate {

//    public static char[] removeAdjacentDuplicate(char[] array){
//        int length = array.length;
//        if(length <= 1){
//            return array;
//        }else{
//            char[] temp = removeAdjacentDuplicate(subArray(array,0,length-2));
//            if(temp==null)
//                return new char[]{array[length-1]};
//            if(temp[temp.length-1] == array[length-1]){
//                return subArray(temp,0,temp.length-2);
//            }else{
//                char[] result = new char[temp.length+1];
//                for(int i=0;i<temp.length;i++){
//                    result[i] = temp[i];
//                }
//                result[temp.length] = array[length-1];
//                return result;
//            }
//
//
//        }
//    }

    public static char[] removeAdjacentDuplicate(char[] array, int left,int right){
       if(left>right){
            return null;
       }else{
            char[] temp = removeAdjacentDuplicate(array,left,right-1);
            if(temp==null)
                return new char[]{array[right]};
            if(temp[temp.length-1] == array[right]){
                return subArray(temp,0,temp.length-2);
            }else{
                char[] result = new char[temp.length+1];
                for(int i=0;i<temp.length;i++){
                    result[i] = temp[i];
                }
                result[temp.length] = array[right];
                return result;
            }


        }
    }

    private static char[] subArray(char[] array,int left,int right){
        if(left>right)
            return null;
        char[] result = new char[right-left+1];
        for(int i=0;i<=right-left;i++){
            result[i] = array[i+left];
        }
        return result;
    }


    public static void main(String[] args) {
        String a= "mississippi";
        char[] result = RemoveAdjacentDuplicate.removeAdjacentDuplicate(a.toCharArray(),0,a.length()-1);
//        char[] result = RemoveAdjacentDuplicate.removeAdjacentDuplicate(new char[]{'b', 'b', 'b','a','a','b','a'},0,1);
        if(result!=null)
        {
            for(int i=0;i<result.length;i++)
                System.out.println(result[i]);
        }
    }


}
