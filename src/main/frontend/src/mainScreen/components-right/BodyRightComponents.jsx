import React, { useEffect, useState } from 'react';
import axios from "axios";
import "./BodyRightComponents.css"
import PostContent from "./components/PostContent";

function BodyRightComponents(props) {
    const [notification, setNotification] = useState([]);
    const [content, setContent] = useState([]);
    const [isCheck, setIsCheck] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('access');
                console.log(response.data);
                setNotification(response.data);
            } catch (error) {
                console.log('Error fetching and parsing data', error);
            }
        };

        fetchData().then(() => {
            // 추가적인 로직 또는 처리할 작업을 여기에 작성합니다.
            console.log('Data fetching completed.');
        });

        const postContent = [
            { postNum: "001", category: "java", title: "자바 기초 상속 강좌 영상 파트1", user: "kym", date: "2023.01.12", views: 231 },
            { postNum: "002", category: "java", title: "자바 기초 상속 강좌 영상 파트2", user: "kym", date: "2023.01.12", views: 21 },
            { postNum: "003", category: "java", title: "자바 기초 상속 강좌 영상 파트3", user: "kym", date: "2023.01.12", views: 201 },
            { postNum: "004", category: "java", title: "자바 기초 상속 강좌 영상 파트4", user: "kym", date: "2023.01.12", views: 271 },
            { postNum: "005", category: "java", title: "자바 기초 상속 강좌 영상 파트5", user: "kym", date: "2023.01.12", views: 31 },
            { postNum: "006", category: "java", title: "자바 기초 상속 강좌 영상 파트6", user: "kym", date: "2023.01.12", views: 121 },
            { postNum: "007", category: "java", title: "자바 기초 상속 강좌 영상 파트7", user: "kym", date: "2023.01.12", views: 23 },
            { postNum: "008", category: "java", title: "자바 기초 상속 강좌 영상 파트8", user: "kym", date: "2023.01.12", views: 200 },
        ];

        setContent(postContent);
    }, []);

    const changeBool = (e) => {
        if (e.target.checked) {
            setIsCheck(true);
        } else {
            setIsCheck(false);
        }
        console.log("isCheck = ", isCheck);
    }

    const onPostCheck = (contentKey) => {
        console.log(contentKey, " 번 글 클릭");
    }

    const notificationContent = () => {
        if (notification) {
            return notification.map((e, index) => {
                return (
                    <PostContent
                        key={index}
                        contentKey={e.postNum}
                        category={e.category}
                        title={e.title}
                        user={e.user}
                        date={e.date}
                        views={e.views}
                        onPostCheck={(e) => { onPostCheck(e) }}
                    />
                );
            });
        }
        return null;
    };


    const post = () => {
        return content.map((e, index) => {
            return <PostContent
                key={index}
                contentKey={e.postNum}
                category={e.category}
                title={e.title}
                user={e.user}
                date={e.date}
                views={e.views}
                onPostCheck={(e) => {
                    onPostCheck(e)
                }}
            />

        });
    }

    return (
        <div className={"bodyRightComponents"}>
            <h1>전체 글 보기</h1>
            <div className={"componentHeader"}>
                <p>{content.length}개의 글</p>
                <div style={{ display: "flex" }}>
                    <input
                        type="checkbox"
                        checked={isCheck}
                        onChange={(e) => { changeBool(e) }}
                    />
                    <p>공지 사항</p>
                </div>
            </div>
            <div>
                <div className={"postHeader"}>
                    <b className={"title"}>제목</b>
                    <div className={"rightPostHeader"}>
                        <b className={"user"}>작성자</b>
                        <b className={"date"}>작성일</b>
                        <b className={"views"}>조회</b>
                    </div>
                </div>
                {isCheck ? null : notificationContent()}
                {post()}
            </div>
        </div>
    );
}

export default BodyRightComponents;
