

interface Store {
    tno: number,
    title: string,
    writer: string,
    regDate? : Date | null,
    modDate? : Date | null
}

interface StoreAdd {
    title: string,
    writer: string,
}