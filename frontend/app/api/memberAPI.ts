import axios from "axios";

const host = import.meta.env.REACT_APP_API_URL;


export const getToken = async (mid:string, mpw:string) => {

    const header = {
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    }

    const res = await axios.post(`${host}`,{uid:mid, upw:mpw}, header);

    console.log(res.data)

    return res.data

}
