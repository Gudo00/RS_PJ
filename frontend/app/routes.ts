import {type RouteConfig, index, route} from "@react-router/dev/routes";
import {lazy} from "react";

const StoreAdd = lazy(() => import("./routes/store/addPage"));

export default [
    index("routes/home.tsx"),
    route('/about','routes/about.tsx'),
    route("/store", "layout/storeLayout.tsx", [
        route("list",'routes/store/listPage.tsx'),
        route("add",'routes/store/addPage.tsx')
    ]),
    route('/member/login', 'routes/member/loginPage.tsx'),
    route('/member/kakao', 'routes/member/kakaoRedirect.tsx'),


] satisfies RouteConfig;