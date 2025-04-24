import axios from "axios";
import type {ActionResult} from "~/types/common";
import jwtAxios from "~/util/jwtUtil";


const host = import.meta.env.REACT_APP_API_URL;

export async function testStoreList(page:string, size:string) {

    const res = await jwtAxios.get(`${host}/list?page=${page}&size=${size}`);

    return res.data
}

export async function testStoreAdd(store:StoreAdd):Promise<ActionResult<number>> {

    await new Promise(resolve => setTimeout(resolve, 2000));
    console.log(store);

    return {result:'success', data: 123}

}

export async function testStoreAddForm(formData:FormData):Promise<ActionResult<number>> {

    await new Promise(resolve => setTimeout(resolve, 2000));
    console.log(formData)

    const res = await axios.post(`${host}`, formData);

    console.log(res)

    return res.data

}






