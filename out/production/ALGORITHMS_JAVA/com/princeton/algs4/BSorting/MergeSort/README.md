# Merge Sort

## ‣ merge sort 

```java
private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid+1, hi);

    // copy to aux[]
    for (int k = lo; k <= hi; k++) {
        aux[k] = a[k];
    }

    // merge back to a[]
    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
        if      (i > mid)              a[k] = aux[j++];
        else if (j > hi)               a[k] = aux[i++];
        else if (less(aux[j], aux[i])) a[k] = aux[j++];
        else                           a[k] = aux[i++];
    }

    // postcondition: a[lo .. hi] is sorted
    assert isSorted(a, lo, hi);
}


// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
}

/**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length-1);
    assert isSorted(a);
}
```

#### Number of Compares and Array Access

**Proposition.**: Merge sort uses at most N lg N compares and 6 NlgN array accesses to sort any array of size N

**Pf sketch.** The number of compares C(N) and array accesses A (N) to merge sort an array of size N satisfy the recurrences:

![image-20220423164220884](../../../../../../utils/statics/mergesort1.png)

#### Divide-and-conquer recurrence: proof by picture

**Proposition1.** If D (N) satisfies D (N) = 2 D (N / 2) + N for N > 1, with D (1) = 0, then D (N) = N lg N

**Pf1.** [assuming N is a power of 2]

![image-20220423164551676](../../../../../../utils/statics/mergesort2.png)

**Proposition2.** If D (N) satisfies D (N) = 2 D (N / 2) + N for N > 1, with D (1) = 0, then D (N) = N lg N.

**Pf 2.** [assuming N is a power of 2]

![image-20220423164708653](../../../../../../utils/statics/merge3.png)

**Proposition3.** If D (N) satisfies D (N) = 2 D (N / 2) + N for N > 1, with D (1) = 0, then D (N) = N lg N. 

**Pf 3.** [assuming N is a power of 2] 

- Base case: N = 1. 

- Inductive hypothesis: D (N) = N lg N. 
- Goal: show that D (2N) = (2N) lg (2N).

![image-20220423164850083](../../../../../../utils/statics/merge4.png)

#### Merge sort analysis: memory

**Proposition.** Mergesort uses extra space proportional to N. 

**Pf.** The array aux[] needs to be of size N for the last merge

**Def.** A sorting algorithm is in-place if it uses **≤ c log N** extra memory. 

**Ex.** Insertion sort, selection sort, shellsort.

Challenge for the bored. **In-place merge**. [Kronrod, 1969]

#### Mergesort: practical improvements

Use insertion sort for small subarrays. 

- Mergesort has too much overhead for tiny subarrays. 

- Cutoff to insertion sort for ≈ 7 items.

```java
private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
    // if (hi <= lo) return;
    if (hi <= lo + CUTOFF) {
        insertionSort(dst, lo, hi);
        return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(dst, src, lo, mid);
    sort(dst, src, mid+1, hi);

    // if (!less(src[mid+1], src[mid])) {
    //    for (int i = lo; i <= hi; i++) dst[i] = src[i];
    //    return;
    // }

    // using System.arraycopy() is a bit faster than the above loop
    if (!less(src[mid+1], src[mid])) {
        System.arraycopy(src, lo, dst, lo, hi - lo + 1);
        return;
    }

    merge(src, dst, lo, mid, hi);
}
```

Stop if already sorted. 

- Is biggest item in first half ≤ smallest item in second half? 
- Helps for partially-ordered arrays

```java
private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
{
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort (a, aux, lo, mid);
    sort (a, aux, mid+1, hi);
    if (!less(a[mid+1], a[mid])) return;
    merge(a, aux, lo, mid, hi);
}
```

**Eliminate the copy to the auxiliary array.** Save time (but not space) by switching the role of the input and auxiliary array in each recursive call.

```java
private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
{
    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) 
    {
        if (i > mid) aux[k] = a[j++];
        else if (j > hi) aux[k] = a[i++];
        else if (less(a[j], a[i])) aux[k] = a[j++];
        else aux[k] = a[i++];
    }
}
private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
{
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort (aux, a, lo, mid);
    sort (aux, a, mid+1, hi);
    merge(a, aux, lo, mid, hi);
}
```



## ‣ bottom-up merge sort 

## ‣ sorting complexity 

## ‣ comparators

## ‣ stability
