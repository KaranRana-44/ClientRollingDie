package com.company;


public class RollingDie {
    /** @return an integer value between 1 and 6
     */
    public int toss()
    {
        return (int)(6 * Math.random()) + 1;
    }

    /** Returns an array of the values obtained by tossing the die numTosses times.
     *  @param numTosses the number of die tosses
     *			Precondition: numTosses >0
     *	@return an array of numTosses values
     */
    public int[] getRolls(int numTosses)
    {
        int[]rolls= new int[numTosses];

        for(int i=0; i<numTosses; i++){
            rolls[i]=toss();
        }

        return rolls;  // replace this
    }

    public int getBestRun(int[] values)
    {
        int count=0;
        int prevcount=1;
        int currval=values[0];
        int prevpos=0;
        int currpos=0;


        for(int i=0; i<values.length; i++){
            if(values[i]==currval) {
                count++;
                }
            else{
                if(count>prevcount){
                    prevcount=count;
                    prevpos=currpos;
                }
                currpos=i;
                count=1;
                currval=values[i];
            }
        }
        if (prevcount==1){return -1;}
        return prevpos;

          //replace this
    }


    public static void main(String[] args) {
        RollingDie nc = new RollingDie();

        for (int p = 0; p < 10; p++) {
            int[] tossArr = nc.getRolls(20);
            for (int i = 0; i < 20; i++)
                System.out.print(tossArr[i] + ",");
            System.out.println();

            int x = nc.getBestRun(tossArr);
            System.out.println(x);
        }

        System.out.println("non-repeating dice set(very low chance of really happening)");
        int[] x= {1,2,3,4,5,6,5,4,3,2,1};
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + ",");
        }
        System.out.println();
        int y=nc.getBestRun(x);
        System.out.println(y);

    }

}