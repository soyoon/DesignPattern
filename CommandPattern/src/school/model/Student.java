package school.model;
public class  Student extends Person{
    private Score[] score= new Score[8];
    private int index;
    public Student(){}
    public Student(String no, String name,int age, String address, String tel){
        super(no, name, age, address,tel);
    }
    public void addScore(Score s){
        if(index < score.length)  score[index++] = s;
        else  System.out.println("더이상 학점을 추가할 수 없습니다");
    }
    public void setScore(Score[] s){ score = s;  }
    public void setScore(Score s, int term){
        if(term>=0 && term < score.length)  score[term] = s;
        else System.out.println("잘 못된 학기를 입력 하셨습니다");
    }
    public Score[] getScore(){return score;}
    public Score getScore(int term){
        if(term>=0 && term < score.length)  return score[term];
        else{
            System.out.println("잘 못된 학기를 입력 하셨습니다");
            return null;
        }
    }
    public String toString(){
        String str="[학점 - ";
        for(int i=0; i<score.length; i++){
            if(score[i] != null)
                str+= score[i].getTerm()+"학기 학점:"+score[i].getTotalavg()+" ";
        }
        str+="]";
        return super.toString()+str;
    }
}
