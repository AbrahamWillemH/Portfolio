N = int(input())

if 1 <= N <= 100000:
    input_string = input()
    tamu = input_string.split()
    
    if all(1 <= len(word) <= 5 and all(ch.isalpha() and ch.islower() for ch in word) for word in tamu):
        tamu.sort() 
        for nama in tamu:
            print(nama)
    else:
        print("Masukan nama tidak sesuai dengan syarat.")
        exit(1)
else:
    print("Masukan diluar batasan. Pastikan N berada dalam rentang 1 hingga 100000.")
