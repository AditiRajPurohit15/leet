class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8)return false;

        boolean hasUpper=false;
        boolean hasLower=false;
        boolean hasDigit=false;
        boolean hasSpecial=false;

        for(int i=0;i<password.length();i++){
            char ch=password.charAt(i);
            if(ch >= 'A' && ch <= 'Z')
    hasUpper = true;
else if(ch >= 'a' && ch <= 'z')
    hasLower = true;
else if(ch >= '0' && ch <= '9')
    hasDigit = true;
else
    hasSpecial = true;

            if(i!=0 && password.charAt(i-1)==ch)return false;

        }
            return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}