using System;
using System.Drawing;
namespace Assign7
{
    [Serializable]
    enum ShapeType
    {
        Ellipse,
        Rectangle,
        Line
    }

    [Serializable]
    struct EllipseStruct
    {
        public Pen pen;
        public Rectangle rect;
    }

    [Serializable]
    struct RectangleStruct
    {
        public Pen pen;
        public Rectangle rect;
    }

    [Serializable]
    struct LineStruct
    {
        public Pen pen;
        public Point pt1;
        public Point pt2;
    }

}