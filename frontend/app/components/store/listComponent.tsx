import {useQuery} from "@tanstack/react-query";
import {testStoreList} from "~/api/storeAPI";
import {Navigate, useSearchParams} from "react-router";


function StoreListComponent () {

    const [searchParams] = useSearchParams();

    const pageStr = searchParams.get("page") || "1"
    const sizeStr = searchParams.get("size") || "10"

    console.log("pageStr: ", pageStr," sizeStr: ", sizeStr)

    // Queries
    const query = useQuery({
        queryKey: ['stores', pageStr, sizeStr],
        queryFn: () => testStoreList(pageStr, sizeStr),
        staleTime: 10 * 60 * 1000,
        retry: false//신선도 판단 기준
    })

    const {isFetching, data, error } = query

    if(error){
        return(
            <Navigate to="/member/login" replace />
        )
    }

    return (
        <div>
            <div className={'text-4xl'}>Store List Component </div>
            <div className={'text-3xl bg-amber-600'}> {isFetching && <h1>Loading.........</h1>}</div>

            {data &&  <div className={'text-2xl'}>List 출력</div>}

        </div>
    )
}

export default StoreListComponent