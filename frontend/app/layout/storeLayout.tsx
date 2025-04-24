import { Link, Outlet } from "react-router";
import {useCountStore} from "~/count/useCountStore";

export default function StoreLayout() {

    const { count } = useCountStore()

    return (
        <div className="min-h-screen bg-gray-100">
            <header className="bg-white shadow">
                <div className="max-w-4xl mx-auto px-4 py-4 flex justify-between items-center">
                    <h1 className="text-2xl font-bold text-gray-800">📝 Store App</h1>
                    <div className={'text-2xl bg-amber-600'}>COUNT {count}</div>
                    <nav className="flex gap-4">
                        <Link
                            to="/store/list"
                            className={`px-3 py-2 rounded-lg text-sm font-medium `}
                        >
                            📋 Store List
                        </Link>
                        <Link
                            to="/store/add"
                            className={`px-3 py-2 rounded-lg text-sm font-medium `}
                        >
                            ➕ Add Store
                        </Link>
                    </nav>
                </div>
            </header>

            <main className="max-w-4xl mx-auto px-4 py-6">
                <Outlet />
            </main>
        </div>
    );
}
