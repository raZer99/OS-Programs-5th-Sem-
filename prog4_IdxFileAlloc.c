// 4. Write a C-program to implement the file allocation technique. (Linked, Indexed or Contiguous)

// INDEXED FILE ALLOCATION
#include <stdio.h>
int main()
{
    int i,j,n,m[20],sb[20],b[20][20],s[20],x;
    printf("Enter no. of blocks : ");
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        printf("Enter starting block and size of file %d : ",i+1);
        scanf("%d %d",&sb[i],&s[i]);
        printf("Enter no. of blocks of file %d : ",i+1);
        scanf("%d",&m[i]);
        printf("Enter blocks occupied by  file %d : ",i+1);
        for(int j=0;j<m[i];j++){
            scanf("%d",&b[i][j]);
        }
    }
    printf("\nFile\tIndex\tlength");
    for(int i=0;i<n;i++){
        printf("\n%d\t%d\t%d",i+1,sb[i],m[i]);
    }
    printf("Enter name of file : ");
    scanf("%d",&x);
    i = x-1;
    printf("Index is : %d ",sb[i]);
    printf("Blocks are : ");
    for(int j=0;j<m[i];j++)
        printf("%3d",b[i][j]);
}




























/*
#include <stdio.h>
int main()
{
    int n, m[20], i, j, sb[20], s[20], b[20][20], x;
    printf("Enter no. of files:");
    scanf("%d", &n);
    for (i = 0; i < n; i++)
    {
        printf("Enter starting block and size of file%d:", i + 1);
        scanf("%d%d", &sb[i], &s[i]);
        printf("Enter blocks occupied by file%d:", i + 1);
        scanf("%d", &m[i]);
        printf("enter blocks of file%d:", i + 1);
        for (j = 0; j < m[i]; j++)
            scanf("%d", &b[i][j]);
    }
    printf("\nFile\t index\tlength\n");
    for (i = 0; i < n; i++)
    {
        printf("%d\t%d\t%d\n", i + 1, sb[i], m[i]);
    }
    printf("\nEnter file name:");
    scanf("%d", &x);
    printf("file name is:%d\n", x);
    i = x - 1;
    printf("Index is:%d", sb[i]);
    printf("Block occupied are:");
    for (j = 0; j < m[i]; j++)
        printf("%3d", b[i][j]);
}
*/

