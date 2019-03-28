import java.util.ArrayList;

public class Matrix {
    //1.класс,конструктор(кол-во строк,кол-во столбцов,min и max знач-я эл-ов(проверка),ArrayList зап-ся случ-ми эл-ми(float))
    //конструктор иниц-ции матрицы(заполняем нолями// )
    //методы setItemValue(x,y,value), float getItemValue(x,y)
    //getMatrix(), найти реднее зн-е на гл-ой и побоч. диаг и сравнить их
    ArrayList<ArrayList<Float>> massiveMatrix=new ArrayList<ArrayList<Float>>();
    Float Sredn1;
    Float Sredn2;
    public Matrix(int index,int min,int max){
        init(index,min,max);
        print(index);
        getGeneralDiag(index);
        getSecondaryDiag(index);
        if(Sredn1>Sredn2){
                setItemValue(index/2,index/2,Sredn1);
            System.out.println("Матрица с замененным центральным элементом на среднее главной диагонали:");
            print(index);
        }
        if(Sredn1<Sredn2){
            setItemValue(index/2,index/2,Sredn2);
            System.out.println("Матрица с замененным центральным элементом на среднее второстепенной диагонали:");
            print(index);
        }

    }
    void init(int index,int min,int max){
        for(int i=0;i<index;i++){
            massiveMatrix.add(i,new ArrayList<>());
        }
        for(int r=0;r<index;r++){
            for(int c=0;c<index;c++){
                max-=min;
                massiveMatrix.get(r).add((float)Math.random()*++max+min);
            }
        }
    }
    void print(int index){
        for(int r=0;r<index;r++){
            System.out.println();
            for(int c=0;c<index;c++){
                System.out.printf("%07.4f ", massiveMatrix.get(r).get(c));
            }
        }

    }
    public void getGeneralDiag(int index) {
        Float Sum=0.0F;
        for(int i=0;i<index;i++) {
            Sum+=massiveMatrix.get(i).get(i);
        }
        Sredn1=Sum/index;
        System.out.println("\r\nСреднее главной диагонали: "+ Sredn1);
    }
    public void getSecondaryDiag(int index) {
        Float Sum=0.0F;
        for(int i=0;i<index;i++) {
            Sum+=massiveMatrix.get(i).get(index-i-1);
        }
        Sredn2=Sum/index;
        System.out.println("Среднее второстепенной диагонали: "+ Sredn2+"\r\n");
    }
    public Float setItemValue(int x,int y,float value){
       return massiveMatrix.get(x).set(y,value);
    }
    public Float getItemValue(int x,int y){
     return massiveMatrix.get(x).get(y);
    }

}
