import StoreAddComponent from "~/components/store/addComponent";


export default function() {

    console.log("Store Add Page")

    return (
        <div>
            <div className={'text-4xl'}>Store Add Page</div>
            <StoreAddComponent></StoreAddComponent>
        </div>
    )
}