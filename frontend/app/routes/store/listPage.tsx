import React from 'react';
import StoreListComponent from "~/components/store/listComponent";
import {useCountStore} from "~/count/useCountStore";

function StoreListPage() {

    const { count, inc } = useCountStore()

    return (
        <div>
            <div className={'text-4xl'}>Store List Page</div>

            <span>{count}</span>
            <button onClick={inc}>one up</button>

            <StoreListComponent></StoreListComponent>

        </div>
    );
}

export default StoreListPage;